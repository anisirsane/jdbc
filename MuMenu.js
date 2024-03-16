import React, { useState } from 'react';
import axios from 'axios';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';

function MuMenu() {
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
            <Button variant="primary" onClick={() => sendData(1)}>Send Data</Button>

            {showCards && ( // Render cards only when showCards is true
                <div>
                    <Card style={{ width: '18rem', marginBottom: '10px' }}>
                        <Card.Body>
                            <Card.Title>Créer un nouveau microcontrôleur</Card.Title>
                            <Card.Text>
                                Créer un nouveau microcontrôleur selon tes besoins.
                            </Card.Text>
                            <Button variant="primary" onClick={() => sendData(11)}>Choisir</Button>
                        </Card.Body>
                    </Card>
                    <Card style={{ width: '18rem', marginBottom: '10px' }}>
                        <Card.Body>
                            <Card.Title>Afficher les microcontrôleurs</Card.Title>
                            <Card.Text>
                                Afficher tout les microcontrôleurs
                            </Card.Text>
                            <Button variant="primary" onClick={() => sendData(13)}>Choisir</Button>
                        </Card.Body>
                    </Card>
                    <Card style={{ width: '18rem', marginBottom: '10px' }}>
                        <Card.Body>
                            <Card.Title>Modifier un microcontrôleur</Card.Title>
                            <Card.Text>
                                Faire des mises à jour sur un microcontrôleur
                            </Card.Text>
                            <Button variant="primary"  onClick={() => sendData(12)}>Choisir</Button>
                        </Card.Body>
                    </Card>
                    <Card style={{ width: '18rem', marginBottom: '10px' }}>
                        <Card.Body>
                            <Card.Title>Supprimer un microcontrôleur</Card.Title>
                            <Card.Text>
                                Supprimer un microcontrôleur selon tes besoins.
                            </Card.Text>
                            <Button variant="primary" onClick={() => sendData(14)}>Choisir</Button>
                        </Card.Body>
                    </Card>
                </div>
            )}
        </div>
    );
}

export default MuMenu;
