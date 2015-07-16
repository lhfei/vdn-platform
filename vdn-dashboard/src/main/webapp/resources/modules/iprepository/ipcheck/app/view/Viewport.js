Ext.define('ifeng.view.Viewport', {
    extend: 'Ext.container.Viewport',

    layout: 'border',
    items: [{
    	id: 'searchForm',
    	itemId: '_searchForm',
    	region: 'north',
    	xtype: 'searchForm',
    	split: 'true'
    },{
    	id: 'aliIPGrid',
    	itemId: '_aliIPGrid',
        region: 'center',
        xtype: 'aliIPGrid',
        split: false
    }]
});
