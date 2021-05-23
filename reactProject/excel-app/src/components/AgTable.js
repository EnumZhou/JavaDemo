import React from 'react';
import { AgGridColumn, AgGridReact } from 'ag-grid-react';
import 'ag-grid-community/dist/styles/ag-grid.css';
import 'ag-grid-community/dist/styles/ag-theme-alpine.css';
import {AppConstant} from "../AppConstants/AppConstant";
import { ModuleRegistry, AllModules } from '@ag-grid-enterprise/all-modules';
import 'ag-grid-enterprise';
import 'ag-grid-community/dist/styles/ag-grid.css';
import 'ag-grid-community/dist/styles/ag-theme-alpine.css';

ModuleRegistry.registerModules(AllModules);


export const AgTable = (props) => {
    return (
        <div className="ag-theme-alpine" style={ { height: 400, width: 800 } }>
            {/*{JSON.stringify(props.data)}*/}
            <AgGridReact
                rowData={props.data}
                pagination={true}
                // rowSelection={'multiple'}
                enableRangeSelection={true}
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
