import React from "react";

export const PdfContainer =(props) => {
    const bodyRef= React.createRef();
    const createPdf = () => props.createPdf(bodyRef.current);

    return (
        <section>
            <section ref={bodyRef}>
                {props.children}
            </section>

            <section>
                <button onClick={createPdf}>Generate PDF</button>
            </section>
        </section>
    );
}
