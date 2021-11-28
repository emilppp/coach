import { makeStyles } from '@mui/styles';
import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router';
import { useNavigate } from 'react-router-dom';
import { Header, Paragraph, Page } from '../..';

interface Game {
    readonly id: number;
    readonly name: string;
    readonly date: string;
}

const games: Game[] = [1, 2, 3, 4, 5].map((i: number) => {
    return {
        id: i,
        name: `Test game ${i}`,
        date: new Date().toDateString(),
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

    const gameItems = games.map(game => {
        return <div 
        className={classes.gameCard} 
        key={game.id}
        onClick={() => navigate(`/games/${game.id}`)}
        >
            <Paragraph variant="h5">{game.id}</Paragraph>
            <Paragraph variant="h6">{game.date}</Paragraph>
            <Paragraph variant="h7">{game.name}</Paragraph>
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
        const newGame: (Game | undefined) = games.find((g: Game) => g.id === Number(id));
        
            setGame(newGame);
    }, []);

    if(!game) return <></>;

    return (
        <Page>
            <Paragraph variant="h6">{game.id}</Paragraph>
            <Paragraph variant="h3">{game.name}</Paragraph>
            <Paragraph variant="h5">{game.date}</Paragraph>
        </Page>
    )
}