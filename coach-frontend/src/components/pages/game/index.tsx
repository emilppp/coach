import { makeStyles } from '@mui/styles';
import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router';
import { useNavigate } from 'react-router-dom';
import { Paragraph, Page } from '../..';

const axios = require('axios');

interface Round {
    readonly round: number;
    readonly description: string;
}

interface Game {
    readonly id: number;
    readonly date: string;
    readonly map: string;
    rounds: Round[];
}

const games: Game[] = [1, 2, 3, 4, 5].map((i: number) => {
    return {
        id: i,
        date: new Date().toDateString(),
        rounds: [],
        map: "korv me bröd",
    }
})

const useStyles = makeStyles((theme : any) => ({
        gameCard: {
            backgroundColor: theme.palette.secondary.main,
            margin: theme.spacing(1),
            padding: theme.spacing(2),
            borderRadius: 5,
            "&:hover": {
                cursor: 'pointer',
            },
        },
        gameList: {
            width: 800,
        },
}));

export const GameListPage = (props: any) => {
    const navigate = useNavigate();
    const classes = useStyles();
    const [games, setGames] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/games')
        .then((response: any) => {
            setGames(response.data);
        })
        .then((error: any) => {
            console.log(error);
        });
    }, []);


    const gameItems = games.map((game: Game) => {
        return <div 
        className={classes.gameCard} 
        key={game.id}
        onClick={() => navigate(`/games/${game.id}`)}
        >
            <Paragraph variant="h5">{game.id}</Paragraph>
            {/* <Paragraph variant="h6">{game.date}</Paragraph>
            <Paragraph variant="h7">{game.name}</Paragraph> */}
            {/* <Link to={`/games/${game.id}`}>View details</Link> */}
        </div>
    })

    return (
        <Page>
            <Paragraph variant="h3">Upcoming games</Paragraph>
            <div className={classes.gameList}>
                {gameItems}
            </div>
        </Page>
    )
}

export const GameDetailsPage = (props: any) => {
    const { id } = useParams();
    const [game, setGame] = useState<Game | undefined>(undefined);

    useEffect(() => {
            axios.get(`http://localhost:8080/games/${id}`)
            .then((response: any)=> {
                console.log(response.data);
                setGame(response.data)
            })
            .catch((error: any) => {
                console.log(error);
            });
    }, []);

    if(!game) return <></>;


    const roundItems = game.rounds.map(round => {
        return (
            <Paragraph variant="h6">{`Round ${round.round} - ${round.description}`}</Paragraph>
        )
    })

    return (
        <Page>
            <Paragraph variant="h6">{game.id}</Paragraph>
            <Paragraph variant="h3">{game.date}</Paragraph>
            <Paragraph variant="h3">{game.map}</Paragraph>
            {roundItems}
        </Page>
    )
}