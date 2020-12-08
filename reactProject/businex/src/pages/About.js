import React,{Fragment} from 'react';
import Header from "../components/Header";
import PageHeader from "../components/PageHeader";
import About from "../components/About/home-two";
import Services from "../components/Services";
// import BrandLogo from "../components/BrandLogo";
import Funfact from "../components/Funfact";
import CallToAction from "../components/CallToAction";
import Footer from "../components/Footer";
import LoginRegister from "../components/LoginRegister";
import MobileMenu from "../components/MobileMenu";
import Features from "../components/Features";
// import Testimonial from "../components/Testimonials/home-two";
// import Team from "../components/Team/home-two";

import ServiceThumb from '../assets/img/about_demo.jpg'

const PageAbout = () => {
    return (
        <Fragment>
            <Header/>
            <PageHeader
                bgImg={require('../assets/img/page-header.jpg')}
                title="ABOUT US"
                content="Viswise always try to provide the best services for Clients to grow up their skills very sharply and smoothly."
            />
            <About
                title={'Our Team'}
                heading="Meet Our <br/> Expert Member"
                thumb={ServiceThumb}
                content="<b>Viswise</b> always try to provide the best Business Solutions for Clients to grow up their skills very sharply and smoothly. 解读华尔街，实现金融梦."
            />
            <Services/>
            <Features classes={'sm-top'}/>
            {/*<Testimonial/>*/}
            {/*<Team/>*/}
            {/*<BrandLogo/>*/}
            <Funfact classes="sp-top"/>
            <CallToAction/>
            <Footer/>
            <LoginRegister/>
            <MobileMenu/>
        </Fragment>
    );
};

export default PageAbout;