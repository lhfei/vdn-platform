Ext.define('ifeng.view.Viewport', {
    extend: 'Ext.container.Viewport',
    layout: 'border',
    id: 'img-chooser-dlg',
    itemId: 'img-chooser-dlg',
    items: [/*{
    	id: 'searchForm',
    	itemId: '_searchForm',
    	region: 'north',
    	xtype: 'searchForm',
    	split: true
    },*/{
    	itemId: 'mainCenterPanel',
        region: 'center',
        xtype: 'panel',
        layout: 'border',
        title: '服务器列表',
        split: true,
        autoScroll: false,
        tools:[{
            xtype: 'tool',
            type: 'unpin',
            itemId: 'hideSearchBtn',
            action: 'hidenSearch'
        },{

            xtype: 'tool',
            type: 'pin',
            itemId: 'showSearchBtn',
            action: 'showSearch'
        }],
        items:[{
        	itemId: 'serverBrowser',
        	id: 'img-chooser-view',
        	xtype: 'serverBrowser',
        	region: 'center',
        	autoScroll: true
        }]
        
    },{
        xtype: 'mainPanel',
        region: 'east',
        header: true,
        split: true,
        autoScroll: false,
        width: 300,
        collapseMode: 'mini',
        collapsible: true
    }]
});