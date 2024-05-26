{
    namespace:package/module_function@2024.2.4-semver = "function-name",
    primitive = [
        true, false, 0, 0xBeef, 0b1010_1010, 3.14e-59,
        'raw string', "multi\nline",
    ],
    options = [0, some(0), none],
    results = [0, fine(0), fail(0)],
    records = {
        bool = true
    },
    variant1 = variant(),
    variant2 = variant(true),
    variant3 = variant(namespace:package/anonymous {
        bool = true
    }),
    special = [none(), true(), false()],
    // nothing + read + write
    flags1 = +[read, write],
    // everything - execute
    flags2 = -[execute],
}