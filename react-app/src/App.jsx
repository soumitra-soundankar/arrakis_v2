import React from 'react';
import Navbar from './components/Navbar';
import Login from './components/Login';
import Sidebar from './components/Sidebar';

const App = () => {
  return (
    <div>
     <Navbar />
      {/* <Login /> */}
      <Sidebar />
    </div>
  );
};

export default App;