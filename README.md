# js-frameworks-poc-portlet for Liferay 6.x
A repository to put some POC with some javascript frameworks integrated with Liferay. First is ReactJS. PRs are wellcome, in react or in any other js framework.

# Why?
Because I really thing that Liferay has a poor UI framework. AlloyUI is enought for classic applications, but not for modern ones.
More on https://web.liferay.com/es/community/forums/-/message_boards/view_message/86775536

# How?
I've made a simple ResourcePortlet to attend portlet:resourceURL requests made by React App. This portlet must be enougth for any other js framework. 
There is a formComponent written in JSX that renders a simple text field and a button to send its content to the server. I've also completed the example with the corresponding service to persist data in the database.

# Test
Deploy the war in your liferay portal and add the app in any page. 
You will see the main screen which only renders one link for every js-framework. 
First is ReactJS.
![Main screen](https://github.com/dtodo1paco/js-frameworks-poc-portlet/blob/master/screenshots/main.png "Main screen")

Click on ReactJS link and you will see the react component rendered.
![ReactJS component](https://github.com/dtodo1paco/js-frameworks-poc-portlet/blob/master/screenshots/react.png "ReactJS component")

Click on Send button and you will see the server response on the screen (also on console log).



