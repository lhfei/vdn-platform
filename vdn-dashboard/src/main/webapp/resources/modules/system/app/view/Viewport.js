Ext.define('Ifeng.view.Viewport', {
    extend: 'Ext.container.Viewport',

    /*requires: [
        'FV.view.Viewer',
        'FV.view.feed.List',
        'Ext.layout.container.Border'
    ],*/

    layout: 'border',
    items: [{
    	id: 'headerPanel',
    	itemId: '_header',
    	region: 'north',
    	height: 50,
    	xtype: 'panel',
    	contentEl: 'header-div'
    },{
    	id: 'centerPanel',
    	itemId: '_cPanel',
        region: 'center',
        //xtype: 'viewer'
        xtype: 'mainPanel',
        //padding: '16 0 0 0 ',
        split:true
    }, {
    	id: 'menuPanel',
    	itemId: '_west',
        region: 'west',
        xtype: 'menuView',
        //padding: '16 0 0 0 ',
        width: 170,
        minWidth: 100,
        maxWidth: 250,
        //xtype: 'feedlist'
        split:true
    }]
});
