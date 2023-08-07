import { React } from "react";

function List(props) {
  const data = [
    {
      id: "hdohfohwfow",
      name: "bond1",
    },
  ];
  const filteredData = data.filter((el) => {
    if (props.input === "") {
      return el;
    } else {
      return el.id.toLowerCase().includes(props.input);
    }
  });
  return (
    <ul>
      {filteredData.map((item) => (
        <li key={item.id}>{item.text}</li>
      ))}
    </ul>
  );
}

export default List;
