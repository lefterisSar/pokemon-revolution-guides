import React from "react";
import CreateBoss from "../BossesComponents/CreateBoss";


const Home = ({bosses}) => {
    return (
       <CreateBoss bosses={bosses}/>
    )
}

export default Home
