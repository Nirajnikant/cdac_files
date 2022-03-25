import logo from './logo.svg';
import './App.css';
import NewsHeader from './components/NewsHeader';
import NewsContent from './components/NewsContent';
import StateComponent from './components/StateComponent';
import NewNews from './components/NewNews';
import SimpleList from './components/skillList/SimpleList';
import Assignment8 from './components/Assignment8';
import EmployeeDataComponent from './components/EmpData/EmployeeDataComponent';
import Formass10 from './components/Formass10';

function App() {

  const onDataHandler = (data) => {
    console.log("in apps",data)
  }

  // const onGetData = (data) => {
  //   console.log('in apps', data);

  // }

  return (
    <div className="App">
      {/* <StateComponent /> */}
      <NewsHeader />
      <NewNews onAddNews={onDataHandler}/>
      <SimpleList />
      {/* <EmployeeDataComponent /> */}
      {/* <Formass10 onName={onGetData}/> */}
      <Formass10 />

      {/* <NewsContent /> */}
    </div>
  );
}

export default App;