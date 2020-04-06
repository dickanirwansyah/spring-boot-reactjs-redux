import React from 'react';
import "bootstrap/dist/css/bootstrap.min.css"
import Navbar from './components/Navbar';
import ProjectBoard from './components/ProjectBoard'; 
import { BrowserRouter as Router, Route} from "react-router-dom";
import AddProjectTask from './components/projectTask/AddProjectTask';
import {Provider} from "react-redux";
import store from "../src/store/store";

function App() {
  return (
    <Provider store={store}>
      <Router>
          <div className="App">
            <Navbar/>
            <Route exact path="/" component={ProjectBoard}/>
            <Route exact path="/addProjectTask" component={AddProjectTask}/>
          </div>
      </Router>
      </Provider>
  );
}

export default App;
