Ext.application({
    name: 'ifeng',

    appFolder: '../resources/modules/iprepository/ipmerge/app',
    // All the paths for custom classes
    paths: {
        'Ext.ux': '../resources/ext4/ux/'
    },

    // Define all the controllers that should initialize at boot up of your application
    controllers: [
        'IPMergeController'
    ],
    
    autoCreateViewport: true
});
