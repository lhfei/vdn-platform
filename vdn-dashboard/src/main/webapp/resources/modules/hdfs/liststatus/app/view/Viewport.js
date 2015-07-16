Ext.define('hwork.view.Viewport', {
    extend: 'Ext.container.Viewport',

    layout: 'border',
    items: [{
    	id: 'fileStatusGrid',
    	itemId: '_fileStatusGrid',
        region: 'center',
        xtype: 'fileStatusGrid',
        split: false
    }]
});
