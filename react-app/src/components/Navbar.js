import React from "react";

const Navbar = () => {
  return (
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">Logo </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarText">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="#">Custom DashBoard</a>
            </li>
            <li class="nav-item">
              <a class="nav-link active" href="#">Analytics</a>
            </li>
            <li class="nav-item">
              <a class="nav-link active" href="#">Pricing</a>
            </li>
          </ul>
             
            <a class="nav-link active">Logout</a>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;
