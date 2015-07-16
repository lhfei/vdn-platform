Ext.define('ifeng.view.ServerWin', {
    extend: 'Ext.window.Window',
    alias: 'widget.serverWin',

    requires: [
        'Ext.form.FieldSet',
        'Ext.form.field.ComboBox',
        'Ext.form.RadioGroup',
        'Ext.form.field.Radio'
    ],

    height: 320,
    width: 480,
    title: '创建服务器',
    maximizable: true,
    minimizable: true,
    modal: true,
    closeAction: 'hide',
    buttons: [{
        text: '提交',
        itemId: 'doSaveServerBtn',
        iconCls: 'icon-search',
        action: 'doSaveServer'
    },{
        text: '重置',
        itemId: 'doResetServerBtn',
        iconCls: 'icon-cancel',
        action: 'doResetServer'
    }],
    
    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
        	items: [{
        		xtype: 'form',
        		header: false,
                items: [
                    {
                        xtype: 'fieldset',
                        margin: '5 5 5 5',
                        defaults: {
                            labelAlign: 'right',
                            anchor: '100%'
                        },
                        collapsible: true,
                        title: '服务器基本信息',
                        items: [
                            {
                                xtype: 'textfield',
                                anchor: '100%',
                                fieldLabel: '外网IP',
                                name: 'ip'
                            },
                            {
                                xtype: 'textfield',
                                anchor: '100%',
                                fieldLabel: '内网IP',
                                name: 'inner_ip'
                            },
                            {
                            	xtype: 'combobox',
                                anchor: '100%',
                                fieldLabel: '所属机房',
                                name: 'room_id',
                                selectOnFocus: true,
                                displayField: 'room_name',
                                store: 'ServerRoomStore',
                                valueField: 'id'
                            },
                            {
                                xtype: 'radiogroup',
                                fieldLabel: '服务器状态',
                                items: [
                                    {
                                        xtype: 'radiofield',
                                        boxLabel: '启用',
                                        checked: true
                                    },
                                    {
                                        xtype: 'radiofield',
                                        boxLabel: '报修'
                                    }
                                ]
                            }
                        ]
                    }
                ]        		
        	}]
        });

        me.callParent(arguments);
    }

});