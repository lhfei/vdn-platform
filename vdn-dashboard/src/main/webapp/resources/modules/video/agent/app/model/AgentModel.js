Ext.define('ifeng.model.AgentModel', {
    extend: 'Ext.data.Model',
    alias: 'model.agentModel',

    requires: [
        'Ext.data.Field'
    ],

    fields: [
		{
		    name: 'id',
		    type: 'int'
		},{
		    name: 'pId',
		    type: 'int'
		},
        {
            name: 'comboLabel',
            type: 'string'
        },
        {
            name: 'comboCode',
            type: 'string'
        },
        {
            name: 'comboKey',
            type: 'string'
        },
        {
            name: 'comboDesc',
            type: 'string'
        }
    ]
});