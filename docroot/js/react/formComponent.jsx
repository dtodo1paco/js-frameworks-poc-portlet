class TestEntityForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            saveOnServer: true,
            sampleText: 'sample text',
            result: ''
        };
        this.handleInputChange = this.handleInputChange.bind(this);
        this.save = this.save.bind(this);
    }
    componentDidMount() {
        console.log(this.props.name + " mounted and ready");
        console.log(this.props.name + " props: " + JSON.stringify(this.props));
    }

    componentWillUnmount(){
        console.log(this.props.name + "ComponentWillUmount");
    }

    handleInputChange(event) {
        const target = event.target;
        const value = target.type === 'checkbox' ? target.checked : target.value;
        const name = target.name;

        this.setState({
            [name]: value
        });
    }
    save() {
        var portletUrl = this.props.portletUrl;
        var portletNS = this.props.portletNS;
        if (this.state.saveOnServer) {
            var param1 = portletNS+"serve_resource_action";
            var param2 = portletNS+"resource";
            var param3 = portletNS+"properties";

            var properties = {};
            properties['testEntityText'] = this.state.sampleText;

            var objPayload= {};
            objPayload[param1] = "save";
            objPayload[param2] = "TestEntity";
            objPayload[param3] = JSON.stringify(properties);
            var payload = querystring.stringify(objPayload);
            var self = this;

            this.serverRequest = axios.post(portletUrl,payload).then(res=> {
                console.log(res);
                if (res.status == 200){
                    this.setState({
                        result: JSON.stringify(res.data)
                    });
                }
            });
        } else {
            this.setState({
                result:"SaveOnServer is deactivated!"
            });
            console.log("SaveOnServer is deactivated!");
        }
    }
    render() {
        return (
            <div>
                <label>
                    Enter a sample text:
                    <input
                        name="sampleText"
                        type="string"
                        value={this.state.sampleText}
                        onChange={this.handleInputChange} />
                </label>
                <br />
                <label>
                    send to Server:
                    <input
                        name="saveOnServer"
                        type="checkbox"
                        checked={this.state.saveOnServer}
                        onChange={this.handleInputChange} />
                </label>
                <br /><br /><br />
                <button onClick={this.save}>Save Value</button>
                <br /><br /><br />
                <label>{this.state.result}</label>
            </div>
        );
    }
}
/* will render from consumer
 <!--... onClick={() => this.save(this.props.portletUrl)}-->
ReactDOM.render(
    <TestEntityForm />,
    document.getElementById('root')
);
*/