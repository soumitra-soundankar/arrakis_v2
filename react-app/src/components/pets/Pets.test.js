import React from "react";
import { render } from "@testing-library/react";
import { Pets } from "./Pets";

describe("<Pets />", () => {
  it("component should render", () => {
    const { container } = render(<Pets />);
    expect(container).toBeDefined();
  });
});
