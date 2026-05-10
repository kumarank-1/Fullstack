import React from "react";
class Clock extends React.Component{
    constructor(props){
        super(props);
        this.state ={
            time:new Date().toLocaleTimeString()
        }
        
    }
    componentDidMount() {
    setInterval(() =>{
        this.setState({
            time : new Date().toLocaleTimeString()
        })
    }, 1000);
    }
    componentWillUnmount(){
        clearInterval(this.timer)
    }
    render(){
        return(
            <>
            <h2>Clock</h2>
            <h3>Time : {this.state.time}</h3>
            </>
        )
    }
}
export default Clock