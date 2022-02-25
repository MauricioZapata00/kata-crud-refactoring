import React, { useState, useEffect } from "react";
import axios from 'axios';
import { useNavigate } from "react-router-dom";
import EditToDoList from "./components/EditToDoList";

function App() {

  const navigate = useNavigate();

  const [ToDos, setToDos] = useState({})
  useEffect(() => {
    showToDoLists();
  },[])

  const showToDoLists = () => {
    axios.get('http://localhost:8080/api/all/lists').then((data) => {
      console.log(data.data);
      setToDos(data.data);
    })
    .catch((err) => {
      console.error(err);
    })

  }

  const editToDoList = (currToDoList) => {
    console.log(currToDoList);
    <EditToDoList currToDoList={currToDoList}/>
    navigate("/ToDoList")
  }

  return (
    <table className="table">
      <thead>
        <tr>
          <td>Listas de ToDo's</td>
        </tr>
        <tr>
          <th scope="col">ID</th>
          <th scope="col">Nombre</th>
        </tr>
      </thead>
      <tbody>
        {
          ToDos.length > 0 ?
          ToDos.map((ToDo) => (
            <tr key={ToDo.toDoListId}>
              <td scope="row">{ToDo.toDoListId}</td>
              <td>{ToDo.name}</td>
              <td>
                <button onClick={() =>{
                  editToDoList(ToDos)}}>Editar Lista</button>
              </td>
              <td>
                <button>Borrar Lista</button>
              </td>

            </tr>
            /*
            ToDos.toDos.length > 0 ?
            ToDos.toDos.map((currToDos) =>(
              <tr>
                <td>{currToDos[0]}</td>
                <td>{currToDos[1]}</td>
              </tr>
            )) : (
              <tr>
                <td>Esta lista no tiene ToDo's</td>
              </tr>
            )
            */
          )) : (
            <tr>
              <td>No hay listas de ToDos</td>
            </tr>
          )
        }
      </tbody>
    </table>
  );
}

export default App;
