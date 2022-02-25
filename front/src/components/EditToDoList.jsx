import React, { useState, useEffect } from "react";
import { useForm } from 'react-hook-form';
import { useNavigate } from "react-router-dom";
import axios from 'axios';

const EditToDoList = () => {

    const navigate = useNavigate();

    const {register, errors, handleSubmit, setValue } = useForm();
    //console.log(props);
    //setValue('id', 1);
    //setValue('name', "Lista 1 Hoy");
    //setValue('complete', false);

    const [listToDo, setListToDo] = useState({})

    useEffect(() => {
        showToDoList();
    },[])

    const showToDoList = () => {
        axios.get(`http://localhost:8080/api/list/${1}`).then((data) => {
          console.log(data.data);
          setValue('toDoListId',data.data.toDoListId);
          setValue('name', data.data.name);
          setListToDo(data.data);
        })
        .catch((err) => {
          console.error(err);
        })
    
      }

    const onSubmit = (data, e) => {
       
        console.log(data);
        //console.log(data.data);
        axios.post('http://localhost:8080/api/save/list', data).then((response) => {
            console.log(response);
        })
        .catch((err) => {
            console.log(err);
        })
        e.target.reset();
        navigate("/")
    }

    return ( 
        <div>
            <form onSubmit={handleSubmit(onSubmit)}>
                <label htmlFor="toDoListId">ID Lista</label>
                <input type="number" name="toDoListId" {...
                    register( 'toDoListId',{
                        required: {value: true, message: 'Campo Requerido'}
                    })
                } />
                <label>Nombre Lista</label>
                <input type="text" name="name" {...
                    register( 'name',{
                        required: {value: true, message: 'Campo Requerido', length: 4}
                    })
                } />
                <div>
                    {errors?.name?.message}
                </div>
                
                <div>
                    {errors?.username?.message}
                </div>
                <button>Agregar/Editar Lista</button>
            </form>
        </div>
     );
}
 
export default EditToDoList;