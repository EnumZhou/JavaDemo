import React, {Fragment} from "react";
import Header from "../components/Header";
import PageHeader from "../components/PageHeader";
import About from "../components/About/page";
import ServiceThumb from "../assets/img/about_demo.jpg";
import TeamMember from "../templates/Team";
import manageTeamData from "../data/Team/manageTeamData.json";
import Funfact from "../components/Funfact";
import CallToAction from "../components/CallToAction";
import Footer from "../components/Footer";
import LoginRegister from "../components/LoginRegister";
import MobileMenu from "../components/MobileMenu";

export const ManageTeam= () => {
    return (
        <Fragment>
            <Header/>
            <PageHeader
                bgImg={require('../assets/img/page-header.jpg')}
                title="KNOW ABOUT VISWISE THE ULTIMATE TEAM"
                content="Viswise always try to provide the best Business Solutions for Clients to grow up their Business very sharply and smoothly."
            />
            <About
                title={'Our Team'}
                heading="Meet Our <br/> Expert Member"
                thumb={ServiceThumb}
                content="<b>Viswise</b> always try to provide the best Business Solutions for Clinets to grow up their Business very sharply and smoothly. We voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt."
            />
            <TeamMember data={manageTeamData}/>
            {/*<BrandLogo/>*/}
            <Funfact classes="sp-top"/>
            <CallToAction/>
            <Footer/>
            <LoginRegister/>
            <MobileMenu/>
        </Fragment>
    );
}