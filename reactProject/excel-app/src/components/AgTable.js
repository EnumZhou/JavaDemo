import React from 'react';
import { AgGridColumn, AgGridReact } from 'ag-grid-react';
import 'ag-grid-community/dist/styles/ag-grid.css';
import 'ag-grid-community/dist/styles/ag-theme-alpine.css';
import {AppConstant} from "../AppConstants/AppConstant";

export const AgTable = (props) => {

    // const handleChange =(params) => {
    //     console.log(params);
    // };
    return (
        <div className="ag-theme-alpine" style={ { height: 400, width: 800 } }>
            {/*{JSON.stringify(props.data.length===0)}*/}
            <AgGridReact
                rowData={props.data}
                rowSelection={'multiple'}
                // onGridReady={handleChange}
            >
                <AgGridColumn field={AppConstant.nameField} sortable={true} filter={true} checkboxSelection={true} />
                <AgGridColumn field={AppConstant.ageField} sortable={true} filter={true} />
                <AgGridColumn field={AppConstant.genderField} sortable={true} filter={true} />
                <AgGridColumn field={AppConstant.courseField} sortable={true} filter={true} />
            </AgGridReact>
        </div>
    );


};
