import React from 'react';
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';
import ChoiceAppMu from './ChoiceAppMu'; // Import the ChoiceAppMu component
import MuMenu from './MuMenu'; // Import the ChoiceAppMu component
import AppareilMenu from './AppareilMenu'; // Import the ChoiceAppMu component



function App() {
    return (
        <div className="container mt-5">
            <div className="row">
                <div className="col-md-6 mb-4">
                    <div className="card">
                        <div className="card-body">
                            <h5 className="card-title">Manipuler des appareils</h5>
                            <p className="card-text">Dans cette partie, on peut faire le CRUD sur les appareils</p>
                            <AppareilMenu />
                        </div>
                    </div>
                </div>
                <div className="col-md-6 mb-4">
                    <div className="card">
                        <div className="card-body">
                            <h5 className="card-title">Manipuler des microcontrôleurs</h5>
                            <p className="card-text">Dans cette partie, on peut faire le CRUD sur les microcontrôleurs</p>
                            <MuMenu />
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default App;
