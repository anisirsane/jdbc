import React, { useState } from 'react';
import axios from 'axios';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';

function AppareilMenu() {
    const [showCards, setShowCards] = useState(false); // State variable to control card visibility

    const sendData = (value) => {
        setShowCards(true);
        axios.post('http://localhost:8001/datachoice', value)
            .then(function (response) {
                console.log(response);
            })
            .catch(function (error) {
                console.log(error);
            });
    };

    return (
        <div>
            {/* Pass a function reference to onClick */}
            <Button variant="primary" onClick={() => sendData(1)}>Send Data</Button>
            {showCards && ( 
                <div>
                    <Card style={{ width: '18rem', marginBottom: '10px' }}>
                        <Card.Body>
                            <Card.Title>Créer un nouveau appareil</Card.Title>
                            <Card.Text>
                                Créer un nouveau appareil selon tes besoins.
                            </Card.Text>
                            <Button variant="primary" onClick={() => sendData(11)}>Choisir</Button>
                        </Card.Body>
                    </Card>
                    <Card style={{ width: '18rem', marginBottom: '10px' }}>
                        <Card.Body>
                            <Card.Title>Afficher les appareils</Card.Title>
                            <Card.Text>
                                Afficher tout les appareil
                            </Card.Text>
                            <Button variant="primary">Choisir</Button>
                        </Card.Body>
                    </Card>
                    <Card style={{ width: '18rem', marginBottom: '10px' }}>
                        <Card.Body>
                            <Card.Title>Modifier un appareil</Card.Title>
                            <Card.Text>
                                Faire des mises à jour sur un appareil
                            </Card.Text>
                            <Button variant="primary">Choisir</Button>
                        </Card.Body>
                    </Card>
                    <Card style={{ width: '18rem', marginBottom: '10px' }}>
                        <Card.Body>
                            <Card.Title>Supprimer un appareil</Card.Title>
                            <Card.Text>
                                Supprimer un appareil selon tes besoins.
                            </Card.Text>
                            <Button variant="primary">Choisir</Button>
                        </Card.Body>
                    </Card>
                </div>
            )}
        </div>
    );
}

export default AppareilMenu;
