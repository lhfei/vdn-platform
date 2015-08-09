//@require @packageOverrides
Ext.Loader.setConfig({
    enabled: true
});


Ext.application({
	name: 'ifeng',
    appFolder: '../../resources/modules/video/agent/app',
    // All the paths for custom classes
    paths: {
        'Ext.ux': '../../resources/ext4/ux/'
    },    
    views: [
        'MainView'
    ],
    controllers: [
        'AgentController'
    ],

    launch: function() {
        Ext.create('ifeng.view.MainView');
    }

});
