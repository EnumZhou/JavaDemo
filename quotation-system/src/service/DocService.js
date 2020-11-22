import { savePDF } from '@progress/kendo-react-pdf';

// dependencies
// "@progress/kendo-react-pdf": "^2.0.0",
// "@progress/kendo-drawing": "^1.5.7",
//  "prop-types": "^15.6.2",
// "react": "^17.0.1",
// "react-dom": "^17.0.1",
//  "rxjs": "^6.3.2",

class DocService {
    createPdf = (html) => {
        savePDF(html, {
            paperSize: 'Letter',
            fileName: 'form.pdf',
            margin: 3
        })
    }
}

const Doc = new DocService();
export default Doc;
