Ext.define('ifeng.view.SearchForm', {
    extend: 'Ext.form.Panel',
    alias: 'widget.searchForm',

    requires: [
        'Ext.form.FieldSet',
        'Ext.form.field.Date'
    ],

    layout: 'fit',
    bodyPadding: 10,
    collapsible: true,
    title: '查询',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'fieldset',
                    defaults: {
                        anchor: '100%',
                        labelAlign: 'right'
                    },
                    layout: 'column',
                    collapsible: true,
                    title: 'Filter',
                    items: [
                        {
                            xtype: 'datefield',
                            columnWidth: 0.5,
                            fieldLabel: '开始日期'
                        },
                        {
                            xtype: 'datefield',
                            columnWidth: 0.5,
                            fieldLabel: '结束日期'
                        }
                    ]
                }
            ]
        });

        me.callParent(arguments);
    }

});