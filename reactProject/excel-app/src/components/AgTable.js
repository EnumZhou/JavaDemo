import React from 'react';
import { AgGridColumn, AgGridReact } from 'ag-grid-react';
import 'ag-grid-community/dist/styles/ag-grid.css';
import 'ag-grid-community/dist/styles/ag-theme-alpine.css';
import {AppConstant} from "../AppConstants/AppConstant";

export const AgTable = (props) => {
    return (
        <div className="ag-theme-alpine" style={ { height: 800, width: 2400 } }>
            {/*{JSON.stringify(props.data)}*/}
            <AgGridReact
                rowData={props.data}
                // rowSelection={'multiple'}
                // onGridReady={handleChange}
            >
                <AgGridColumn field={AppConstant.dateField} sortable={true} filter={true} resizable={true} />
                <AgGridColumn field={AppConstant.usernameField} sortable={true} filter={true} resizable={true} />
                <AgGridColumn field={AppConstant.emailField} sortable={true} filter={true} resizable={true} />
                <AgGridColumn field={AppConstant.countryField} sortable={true} filter={true} resizable={true}/>
                <AgGridColumn field={AppConstant.productField} sortable={true} filter={true} resizable={true}/>
                <AgGridColumn field={AppConstant.invoiceField} sortable={true} filter={true} resizable={true}/>
                <AgGridColumn field={AppConstant.couponField} sortable={true} filter={true} resizable={true} />
                <AgGridColumn field={AppConstant.transactionIdField} sortable={true} filter={true}resizable={true}/>
                <AgGridColumn field={AppConstant.amountField} sortable={true} filter={true} resizable={true}/>
                <AgGridColumn field={AppConstant.product_priceField} sortable={true} filter={true} resizable={true}/>
                <AgGridColumn field={AppConstant.product_typeField} sortable={true} filter={true} resizable={true}/>
                <AgGridColumn field={AppConstant.sales_feeField} sortable={true} filter={true} resizable={true}/>
            </AgGridReact>
        </div>
    );


};
