Ext.define('ifeng.view.AllFilter', {
    extend: 'Ext.form.Panel',
    alias: 'widget.allFilter',

    requires: [
        'Ext.form.FieldSet',
        'Ext.form.Panel',
        'Ext.form.field.ComboBox',
        'Ext.button.Button'
    ],
    bodyPadding: 5,
    title: '全部',
    header: false,
    autoScroll: true,
    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'fieldset',
                    autoScroll: true,
                    collapsible: true,
                    title: '',
                    autoHeight: false,
                    height: 350,
                    items: [{
                    	height: 310,
                    	contentEl: 'avlbChart'
                    }]
                },{
                	xtype: 'fieldset',
                	padding: '5 5 5 5',
                	collapsible: true,
                	collapsed: true,
                	autoHeight: true,
                	checkboxToggle: true,
                	title: '明细数据',
                	width: '99%',
                    layout: 'fit',
                	items: [{
                		xtype: 'dailyGrid'
                	}]
                	
                }
            ]
        });

        me.callParent(arguments);
    }

});