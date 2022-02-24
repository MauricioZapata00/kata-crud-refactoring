import './App.css';

function App() {
  return (
    <table className="table">
      <thead>
        <div>
          Lista de ToDo's
        </div>
        <tr>
          <th scope="col">ID</th>
          <th scope="col">Nombre</th>
          <th scope="col">Completado</th>
        </tr>
      </thead>
      <tbody>
        Aquí viene la info
      </tbody>
    </table>
  );
}

export default App;
