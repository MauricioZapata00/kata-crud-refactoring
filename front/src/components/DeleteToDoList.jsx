import React from "react";
import { useForm } from 'react-hook-form';
import { useNavigate } from "react-router-dom";
import axios from 'axios';

const DeleteToDoList = () => {
    const {register, errors, handleSubmit, setValue } = useForm();
    //console.log(props);

    const navigate = useNavigate();
    setValue('id', 1);

    const onSubmit = (data, e) => {
       
        console.log(data);
        console.log(data.id);
        axios.delete(`http://localhost:8080/api/delete/list/${data.id}`).then((response) => {
            console.log(response);
        })
        .catch((err) => {
            console.log(err);
        })
        e.target.reset();
        navigate("/")
    }

    return ( 
        <div className="container">
            <form onSubmit={handleSubmit(onSubmit)}>
                <label htmlFor="id">Lista ID</label>
                <input type="number" name="id" {...
                    register( 'id',{
                        required: {value: true, message: 'Campo Requerido'}
                    })
                } />
                <div>
                    {errors?.name?.message}
                </div>
                <button>Borrar Lista</button>
            </form>
            <div>
                Para borrar Lista de ToDo por número de ID
            </div>
        </div>
     );
}
 
export default DeleteToDoList;