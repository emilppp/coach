import React from 'react';
import { Page, Paragraph, Link, Panel, Spacer } from '../..';
import { makeStyles } from '@mui/styles';

const useStyles = makeStyles((theme : any) => ({
        page: {
            height: '100vh',
            width: '100vw',
            overflow: 'hidden',
            // padding: theme.spacing(1),
        },
        content: {
            // margin: theme.spacing(1),
            padding: theme.spacing(3),
        },
        typography: {
            color: 'white',
        },
        header: {
            height: 50,
            marginBottom: 25,
            paddingBottom: 15,
            display: 'flex',
            flexDirection: 'row',
            alignItems: 'flex-end',
            backgroundColor: theme.palette.secondary.dark,
            padding: theme.spacing(3),
        },
        footer: {
            height: 50,
            position: 'absolute',
            bottom: 0,
            display: 'flex',
            flexDirection: 'column',
            justifyContent: 'center',
            alignItems: 'center',
            width: '100%',
        },
        spacer: {
            display: 'flex',
            flexGrow: 1,
        },
        link: {
            color: 'white',
        }
}));

export const HomePage = (props: any) => {
    return (
        <Page>
            <Panel style={{height: 800}}>
                <Paragraph variant="h4">Welcome</Paragraph>
                <Paragraph variant="body">
                    Welcome to Coach! Plan your events, document your progress and coordinate with your teammates.
                </Paragraph>
                <Link style={{marginTop: 50}} to="/games">See games</Link>
            </Panel>
        </Page>
    )
}