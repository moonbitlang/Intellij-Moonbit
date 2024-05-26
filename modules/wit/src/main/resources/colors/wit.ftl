package wasi:io@0.2.0;

default world {

}

/// WASI I/O is an I/O abstraction API which is currently focused on providing stream types.
interface streams {
    use error.{error};
    use poll.{pollable};

    variant stream-error {
        last-operation-failed(error),
        closed
    }

    resource input-stream {
        read: func(len: u64) -> result<list<u8>, stream-error>;
    }
}