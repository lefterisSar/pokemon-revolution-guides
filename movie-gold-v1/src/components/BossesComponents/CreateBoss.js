import React, { useState } from 'react';
import {TextField, Button, Autocomplete, MenuItem, Select} from '@mui/material';

export
function CreateBossForm() {

    const [bossName, setBossName] = useState('');
    const [region, setRegion] = useState('');
    const [location, setLocation] = useState('');
    const [cooldown, setCooldown] = useState('');
    const [lineup, setLineup] = useState([{ name: '', moves: [] }]);
    const [reward, setReward] = useState({ pokedexEntry: '', pokemonRewarded: {}, accessTo: [] });
    const [difficulty, setDifficulty] = useState({});
    const [moves, setMoves] = useState([]);

    const handleLineupChange = (index, event) => {
        const newLineup = lineup.map((pokemon, i) => {
            if (i === index) {
                return { ...pokemon, [event.target.name]: event.target.value };
            }
            return pokemon;
        });
        setLineup(newLineup);
    };

    const handleCreateBoss = async () => {
        const bossData = {
            name: bossName,
            region: region,
            location: location,
            cooldown: cooldown,
            difficulty:difficulty,
            lineup: lineup,
            reward: reward,
        };

        try {
            const response = await fetch('http://localhost:8080/api/bosses',
            {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(bossData),
            });

            if (response.ok) {
                const result = await response.json();
                console.log('Boss created:', result);
                // Handle success - maybe clear form or show success message
            } else {
                console.error('Failed to create boss', response.status);
                // Handle errors - show error message to user
            }
        } catch (error) {
            console.error('There was an error creating the boss', error);
            // Handle errors - show error message to user
        }
    };

    const handleRegionChange = (event) => {
        setRegion(event.target.value);
    };
    const handleDifficultyChange = (event) => {
        setDifficulty(event.target.value);
    };


    return (
        <div>
            <TextField
                label="Boss Name"
                value={bossName}
                onChange={(e) => setBossName(e.target.value)}
            />
            <Select
                labelId="demo-simple-select-helper-label"
                id="demo-simple-select-helper"
                value={region}
                label="Region"
                autoWidth
                onChange={handleRegionChange}>
                <MenuItem value={"Kanto"}>Kanto</MenuItem>
                <MenuItem value={"Johto"}>Johto</MenuItem>
                <MenuItem value={"Hoenn"}>Hoenn</MenuItem>
            </Select>

            <Select
                labelId="difficulty"
                id="difficulty"
                value={difficulty}
                label="Difficulty"
                autoWidth
                onChange={handleDifficultyChange}>
                <MenuItem value={"Easy"}>Easy</MenuItem>
                <MenuItem value={"Medium"}>Medium</MenuItem>
                <MenuItem value={"Hard"}>Hard</MenuItem>
            </Select>


            <TextField
                label="Location"
                value={location}
                onChange={(e) => setLocation(e.target.value)}
            /> 
            <TextField
                label="Cooldown"
                value={cooldown}
                onChange={(e) => setCooldown(e.target.value)}
            />

            <TextField
                label="Moves"
                value={moves}
                onChange={(e) => setCooldown(e.target.value)}
            />
            

            <Button variant="contained" color="primary" onClick={handleCreateBoss}>
                Create Boss
            </Button>
        </div>
    );
}

export default CreateBossForm;