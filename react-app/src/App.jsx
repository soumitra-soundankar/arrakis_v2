import React from "react";
import SearchBar from "./components/SearchBar";
import Navbar from "./components/Navbar";
import Sidebar from "./components/Sidebar";
import { FlexRow } from "./components/Containers";
import Header from "./components/Header";

const App = () => {
  return (
    <>
      <Navbar />
      <Header />
      <FlexRow>
        <Sidebar />
        <SearchBar />
      </FlexRow>
    </>
  );
};

export default App;
