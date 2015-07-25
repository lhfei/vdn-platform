Ext.define('ifeng.view.MainView', {
    extend: 'Ext.container.Viewport',

    itemId: 'mainView',
    layout: 'border',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                /*{xtype: 'searchForm',
                region: 'north',
                split: true
            },
            */{xtype: 'dailyPanel',
            region: 'center',
            split: true
        }
    ]
        });

        me.callParent(arguments);
    }

});