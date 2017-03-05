<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<portlet:defineObjects />

This is the
<b>React Portlet</b>
portlet in View mode.

<!-- The container where the code will be rendered -->
<div id="app"></div>
<div id="root"></div>
<!-- React -->
<script src='https://cdnjs.cloudflare.com/ajax/libs/react/15.4.2/react.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/react/15.4.2/react-dom.min.js'></script>

<script src="js-frameworks-poc-portlet/js/lib/querystring.min.js" type="text/babel"></script>
<!-- Axios to make HTTP requests -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.15.3/axios.js"
	integrity="sha256-CoA7Q6Hwn87/erPTxiI0k/susrtAfkh8i84ZdSWAzAM="
	crossorigin="anonymous"></script>

<!-- required to interpreter jsx files -->
<script src="https://unpkg.com/babel-standalone@6/babel.min.js"></script>
<!-- My code -->
<script src="js-frameworks-poc-portlet/js/react/formComponent.jsx" type="text/babel"></script>
<script type="text/babel">
var PORTLET_SERVE_RESOURCE_URL = '<portlet:resourceURL />';
var PORTLET_NAMESPACE = '<portlet:namespace />';

function App() {
  return (
    <div>
      <TestEntityForm portletNS={PORTLET_NAMESPACE} portletUrl={PORTLET_SERVE_RESOURCE_URL} name="TestEntityForm" />
    </div>
  );
};
ReactDOM.render(<App />, document.getElementById('app'));
</script>