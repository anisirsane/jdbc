import React from 'react';
import axios from 'axios';

function ChoiceAppMu({ parametre }) {
    const sendData = () => {
        axios.post('http://localhost:8001/datachoice', parametre)
            .then(function (response) {
                console.log(response);
            })
            .catch(function (error) {
                console.log(error);
            });
    };

    return (
        <button onClick={sendData}>Send Data</button>
    );
}

export default ChoiceAppMu;
