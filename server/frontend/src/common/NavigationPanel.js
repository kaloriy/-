import React, {Component} from "react";
import {Col} from 'reactstrap';
import './NavigationPanel.css'

export default class NavigationPanel extends Component{

    constructor(props) {
        super(props);
    }

        render() {
        return(
            <Col sm={{ size: 2.7}} className='col-navigation'>
                <a href='/'><div style={{paddingTop:10}} className='row-navigation'>Главная</div></a>
                <a href='/' className='navigation-link-red'><div className='row-navigation'>Дни рождения</div></a>
                {/*<a href={`/users/${this.props.currentUser.username}`}><div className='row-navigation'>Карточка сотрудника</div></a>*/}
                <a href='/' className='navigation-link-red'><div className='row-navigation'>Карточка сотрудника</div></a>
                <a href='/users'><div className='row-navigation'>Адресная книга сотрудников</div></a>
                <a href='/' className='navigation-link-red'><div className='row-navigation'>Бронирование переговорных</div></a>
                <a href='/editUsers' ><div className='row-navigation'>Управление сотрудниками</div></a>
                <a href='/roleManager'><div className='row-navigation'>Управление ролями</div></a>
                <a href='/about' ><div className='row-navigation'>О компании</div></a>
                <a href='/' className='navigation-link-red'><div className='row-navigation'>Новости</div></a>
            </Col>
        )
    }
}