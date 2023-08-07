import React from 'react';

const Sidebar = () => {
  return (
    <nav id="sidebar" className="text-bg-light p-4 " style={{ width: '20%', height: '100vh' }}>
      

      <ul className="list-unstyled components">
        <li className="active my-2 hover-color-change">
          <a href="#" className="text-dark text-decoration-none">
            <i className="fas fa-home mr-2 "></i> Matured
          </a>
        </li>
        <li className="my-2">
          <a href="#" className="text-dark text-decoration-none">
            <i className="fas fa-info-circle mr-2"></i> Pending
          </a>
        </li>
      </ul>
    </nav>
  );
};

export default Sidebar;
