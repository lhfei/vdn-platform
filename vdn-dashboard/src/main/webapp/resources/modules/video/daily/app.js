//@require @packageOverrides
Ext.Loader.setConfig({
    enabled: true
});


Ext.application({
	name: 'ifeng',
    appFolder: '../../resources/modules/video/daily/app',
    // All the paths for custom classes
    paths: {
        'Ext.ux': '../../resources/ext4/ux/'
    },    
    views: [
        'MainView'
    ],
    controllers: [
        'DailyController'
    ],

    launch: function() {
        Ext.create('ifeng.view.MainView');
    }

});
