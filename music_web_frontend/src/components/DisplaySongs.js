import React from 'react';
import SpringBootAPI from '../API/SpringBoot';

class DisplaySongs extends React.Component{
    constructor(props){
        super(props);
        this.state = {
            songs:[]
        }
    }

    componentDidMount(){
        SpringBootAPI.getSongs().then((response) =>{
            this.setState({songs : response.data})
        });
    }

    render (){
        return(
            <div>
                {
                    this.state.songs.map(
                        song => 
                        <tr>
                            <td>{song.name}</td>
                            <td>{song.artist}</td>
                        </tr>
                        )
                }
            </div>
        )
    }
}

export default DisplaySongs;
