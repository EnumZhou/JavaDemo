import React, { useState } from 'react';
import { AgGridColumn, AgGridReact } from 'ag-grid-react';

import 'ag-grid-community/dist/styles/ag-grid.css';
import 'ag-grid-community/dist/styles/ag-theme-alpine.css';

export const AgTable = (props) => {
    const [gridApi, setGridApi] = useState(null);
    const [gridColumnApi, setGridColumnApi] = useState(null);

    // const [rowData, setRowData] = useState([
    //     {make: "Toyota", model: "Celica", price: 35000},
    //     {make: "Ford", model: "Mondeo", price: 32000},
    //     {make: "Porsche", model: "Boxter", price: 72000}
    // ]);


    return (
        <div className="ag-theme-alpine" style={ { height: 400, width: 800 } }>
            <AgGridReact
                rowData={props.data}>
                <AgGridColumn field="NAME" sortable={true} filter={true}></AgGridColumn>
                <AgGridColumn field="AGE" sortable={true} filter={true}></AgGridColumn>
                <AgGridColumn field="GENDER" sortable={true} filter={true}></AgGridColumn>
                <AgGridColumn field="COURSE" sortable={true} filter={true}></AgGridColumn>
            </AgGridReact>
        </div>
    );
}
