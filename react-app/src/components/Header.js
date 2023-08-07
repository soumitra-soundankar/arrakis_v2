import React from "react";
import "../App.css"; // Import the CSS file for styling
import { Box, Button, Typography } from "@mui/material";
import { FlexRowAlignCenter, FlexRowSpaceBetween } from "./Containers";

const Header = () => {
  return (
    <FlexRowSpaceBetween style={{ padding: "10px" }}>
      <Typography
        variant="h4"
        noWrap
        component="div"
        sx={{ display: { xs: "none", sm: "block" } }}
      >
        Company Name
      </Typography>
      <Button size="small" variant="contained">
        <Typography
          variant="body1"
          noWrap
          component="div"
          sx={{ display: { xs: "none", sm: "block" } }}
        >
          Create
        </Typography>
      </Button>
    </FlexRowSpaceBetween>
  );
};

export default Header;
