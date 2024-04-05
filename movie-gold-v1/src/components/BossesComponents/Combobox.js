import {Autocomplete, TextField} from "@mui/material";
import React from "react";

function ComboBox() {
    return (
        <Autocomplete
            disablePortal
            id="combo-box-demo"
            options={Regions}
            sx={{ width: 300 }}
            onChange={(event, newValue) => {
                setRegion(newValue);
            }}
            renderInput={(params) => <TextField {...params} label="Region" />}
        />
    );
}