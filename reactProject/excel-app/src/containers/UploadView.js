import React, {useState} from "react";
import {readExcel} from "../services/ReadExcel";
import {AgTable} from "../components/AgTable";

export const UploadView = () => {

    const [state,setState] = useState([]);

    return (
            <>
                <div>Import Sales Report Excel</div>
                <input type="file"
                       name ="Choose a excel file"
                       onChange={(e) =>{
                           const file=e.target.files[0];
                           const promise=readExcel(file);
                           promise.then(d => setState(d));
                       }}/>

                  <h2>Sales Report Table</h2>
                  <AgTable data={state}/>
             </>
    );
};
