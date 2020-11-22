import React from "react";
import TableContainer from "@material-ui/core/TableContainer";
import Paper from "@material-ui/core/Paper";
import Table from "@material-ui/core/Table";
import TableRow from "@material-ui/core/TableRow";
import TableCell from "@material-ui/core/TableCell";
import TableHead from "@material-ui/core/TableHead";
import TableBody from "@material-ui/core/TableBody";

function createData(name,calories,fat,carbs,protein) {
    return [name,calories,fat,carbs,protein];
}
const columns= ["Dessert","Calories","Fat","Carbs","Protein"];

const rows = [
    createData('Frozen yoghurt', 159, 6.0, 24, 4.0),
    createData('Ice cream sandwich', 237, 9.0, 37, 4.3),
    createData('Eclair', 262, 16.0, 24, 6.0),
    createData('Cupcake', 305, 3.7, 67, 4.3),
    createData('Gingerbread', 356, 16.0, 49, 3.9),
];

export const CustomizedTable = () => {
    return (
        <TableContainer component={Paper}>
            <Table>
                <TableHead style={{backgroundColor:"#999999"}}>
                    <TableRow key="head">
                        {columns.map( e => <TableCell key={e}>{e}</TableCell>)}
                    </TableRow>
                </TableHead>
                <TableBody>
                    {rows.map(row => (
                        <TableRow key={row[0]}>
                            {row.map(e => <TableCell key={e}>{e}</TableCell>)}
                        </TableRow>
                    ))}
                </TableBody>
            </Table>
        </TableContainer>
    );
}
