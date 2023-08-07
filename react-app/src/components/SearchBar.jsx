import * as React from "react";
import { styled, alpha } from "@mui/material/styles";
import Box from "@mui/material/Box";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import InputBase from "@mui/material/InputBase";
import SearchIcon from "@mui/icons-material/Search";
import { Button } from "@mui/material";

const Search = styled("div")(({ theme }) => ({
  position: "relative",
  borderRadius: theme.shape.borderRadius,
  backgroundColor: alpha(theme.palette.common.white, 0.75),
  "&:hover": {
    backgroundColor: alpha(theme.palette.common.white, 0.6),
  },
  marginRight: theme.spacing(2),
  marginLeft: 0,
  width: "100%",
  [theme.breakpoints.up("sm")]: {
    marginLeft: theme.spacing(3),
    width: "auto",
  },
}));

const SearchIconWrapper = styled("div")(({ theme }) => ({
  padding: theme.spacing(0, 1),
  height: "100%",
  position: "absolute",
  pointerEvents: "none",
  display: "flex",
  alignItems: "center",
  justifyContent: "center",
  color: "gray",
}));

const StyledInputBase = styled(InputBase)(({ theme }) => ({
  "& .MuiInputBase-input": {
    padding: theme.spacing(1, 1, 1, 0),
    // vertical padding + font size from searchIcon
    paddingLeft: `calc(1em + ${theme.spacing(3)})`,
    transition: theme.transitions.create("width"),
    width: "100%",
    [theme.breakpoints.up("md")]: {
      width: "20ch",
    },
    border: "2px solid #c5cfe3",
    "&:hover": {
      border: "2px solid #5c79af",
    },
    borderRadius: "5px",
  },
}));

export default function SearchBar() {
  return (
    <Box
      sx={{ flexGrow: 1 }}
      height={"fit-content"}
      backgroundColor={"lightgray"}
    >
      <Toolbar style={{ padding: "10px" }}>
        <Search>
          <SearchIconWrapper>
            <SearchIcon />
          </SearchIconWrapper>
          <StyledInputBase
            placeholder="Search by Security ID"
            inputProps={{ "aria-label": "search" }}
          />
        </Search>
        <Box sx={{ flexGrow: 1 }} />
        <Box sx={{ display: { xs: "none", md: "flex", columnGap: "20px" } }}>
          <Button size="small" variant="outlined">
            <Typography
              variant="body1"
              noWrap
              component="div"
              sx={{ display: { xs: "none", sm: "block" } }}
            >
              Sort
            </Typography>
          </Button>
          <Button size="small" variant="outlined">
            <Typography
              variant="body1"
              noWrap
              component="div"
              sx={{ display: { xs: "none", sm: "block" } }}
            >
              Export
            </Typography>
          </Button>
        </Box>
      </Toolbar>
    </Box>
  );
}
