Ext.define('ifeng.model.AvlbMinutelyGrid', {
    extend: 'Ext.data.Model',
    alias: 'model.avlbMinutelyGrid',

    requires: [
        'Ext.data.Field',
        'Ext.data.reader.Json'
    ],

    fields: [
        {
            name: 'isp',
            type: 'string'
        },
        {
            name: 'ct',
            type: 'string'
        },
        {
        	name: 'tr',
        	type: 'string'
        },
        {
        	name: 'cat',
        	type: 'string'
        },
        {
            name: 'a',
            type: 'int'
        },
        {
            name: 'b',
            type: 'int'
        },
        {
            name: 'c',
            type: 'float'
        },
        {
            name: 'c2',
            type: 'int'
        },
        {
            name: 'c3',
            type: 'int'
        },
        {
            name: 'c4',
            type: 'float'
        },
        {
            name: 'd',
            type: 'int'
        },
        {
            name: 'd2',
            type: 'int'
        },
        {
            name: 'd3',
            type: 'int'
        },
        {
            name: 'e',
            type: 'float'
        },
        {
            name: 'f',
            type: 'int'
        },
        {
            name: 'f2',
            type: 'int'
        },
        {
            name: 'g',
            type: 'int'
        },
        {
            name: 'g2',
            type: 'int'
        },
        {
        	name: 'ka',
        	type: 'float'
        },
        {
        	name: 'kb',
        	type: 'float'
        },
        {
        	name: 'kc',
        	type: 'float'
        },
        {
        	name: 'kc2',
        	type: 'float'
        },
        {
        	name: 'kc3',
        	type: 'float'
        },
        {
        	name: 'kc4',
        	type: 'float'
        },
        {
        	name: 'kd',
        	type: 'float'
        },
        {
        	name: 'kd2',
        	type: 'float'
        },
        {
        	name: 'kd3',
        	type: 'float'
        },
        {
        	name: 'ke',
        	type: 'float'
        },
        {
        	name: 'kf',
        	type: 'float'
        },
        {
        	name: 'kf2',
        	type: 'float'
        },
        {
        	name: 'kf3',
        	type: 'float'
        }
    ]
});